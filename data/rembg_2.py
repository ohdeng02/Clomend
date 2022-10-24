import time
import io
import numpy as np
import matplotlib.pyplot as plt
from PIL import Image, ImageFile
ImageFile.LOAD_TRUNCATED_IMAGES = True
from rembg import remove_bg
from PIL import Image

def rembg(n):
    path = 'C:/Users/Daeun/종프/imgs/img{}.png'.format(n)
    fig = plt.figure(figsize=(10, 10))
    
    # 원본 이미지 show
    fig.add_subplot(1, 2, 1)
    orig_img = Image.open(path)
    #plt.imshow(orig_img)
    
    # 배경 제거한 이미지 show
    fig.add_subplot(1, 2, 2)
    byteImg = Image.open(path)
    
    byteImgIO = io.BytesIO()
    byteImg.save(byteImgIO, "PNG")
    byteImgIO.seek(0)
    byteImg = byteImgIO.read()
    
    result = remove_bg(byteImg)
    img = Image.open(io.BytesIO(result)).convert("RGBA")
    #plt.imshow(img)
    
    # png 확장자로 저장
    img.save("C:/Users/Daeun/종프/rembg_imgs/img{}.png".format(n), "PNG") 
    
# main
for i in range(60):
    rembg(i)