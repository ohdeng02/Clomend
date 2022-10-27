import extcolors
from PIL import Image

def rgb_to_hsv(r, g, b):
    r, g, b = r/255.0, g/255.0, b/255.0
    mx = max(r, g, b)
    mn = min(r, g, b)
    df = mx-mn
    if mx == mn:
        h = 0
    elif mx == r:
        h = (60 * ((g-b)/df) + 360) % 360
    elif mx == g:
        h = (60 * ((b-r)/df) + 120) % 360
    elif mx == b:
        h = (60 * ((r-g)/df) + 240) % 360
    if mx == 0:
        s = 0
    else:
        s = (df/mx)*100
    v = mx*100
    return  round(h,2),  round(s,2),  round(v,2)

# main
# 상의 img HSV 값 구하기
for i in range(43,44):
    print("\n상의 img{}의 HSV값".format(i))
    
    img = Image.open("C:/Users/Daeun/종프/crop_imgs/top/top_img{}.png".format(i))
    
    colors, pixel_count = extcolors.extract_from_image(img)
    
    pixel_output = 0
    for c in colors:
        pixel_output += c[1]
        ratio = round((c[1] / pixel_count) * 100, 2)
        if ratio >= 15:
            print('{0} {1}%'.format(rgb_to_hsv(c[0][0],c[0][1],c[0][2]), ratio))
    

