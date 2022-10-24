from PIL import Image
def top_crop(img_num):
    
    path = Image.open("C:/Users/Daeun/종프/rembg_imgs/img{}.png".format(img_num)) 
    
    croppedImage = path.crop((60,60,180,200))
    #croppedImage.show()
    
    croppedImage.save("C:/Users/Daeun/종프/crop_imgs/top/top_img{}.png".format(img_num))

def bottom_crop(img_num):
    
    path = Image.open("C:/Users/Daeun/종프/rembg_imgs/img{}.png".format(img_num)) 
    
    croppedImage = path.crop((60,155,180,375))
    #croppedImage.show()
    
    croppedImage.save("C:/Users/Daeun/종프/crop_imgs/bottom/bottom_img{}.png".format(img_num))

# 메인    

# img0 ~ img59까지 상의/하의 부분 crop
for i in range(60): 
    top_crop(i)
    bottom_crop(i)
    
'''
crop(9)

list = [44]
for i in list:
    crop(i)
'''