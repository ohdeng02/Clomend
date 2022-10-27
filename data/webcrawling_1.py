from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.chrome.service import Service as ChromeService
import urllib.request
import time
import os

dr = webdriver.Chrome(executable_path='C:/Users/Daeun/Downloads/chromedriver_win32/chromedriver.exe')
# 3초 기다리기
dr.implicitly_wait(3)


def crawling(pages):
    total_images=[]
    imgs = []
    for num in range(pages):
        # 크롤링 할 페이지 url에 접근
        dr.get('https://www.musinsa.com/mz/brandsnap?ordw=inc&p={}'.format(num+1))
        
        items = dr.find_element(By.CLASS_NAME,"list-box.box")
        images = items.find_elements(By.CLASS_NAME,"listItem")
        total_images += images

        next = 60*num
        # 한 페이지에 이미지 수 : 60
        for i in range(0+next, 60+next):
            imgs.append(total_images[i].find_element(By.CSS_SELECTOR,'a > img'))

        image_urls = []
        for img in imgs[0+next: 60+next]:
            image_urls.append(img.get_attribute("src"))
            
        # 이미지 저장하기
        outdir = "C:/Users/Daeun/종프/imgs/" #지정 이미지 저장 디렉토리
        if not os.path.isdir(outdir): #디렉토리가 존재하지 않는다면 생성
            os.makedirs(outdir)
            
        for idx, image_url in enumerate(image_urls):
            urllib.request.urlretrieve(image_url,outdir+"img{}.png".format(idx+next))
            
        # 다음 페이지 가기 전 10초 기다리기  
        dr.implicitly_wait(10)
        
# main
crawling(1)