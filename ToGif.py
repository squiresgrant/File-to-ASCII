import glob
from PIL import Image
import os
import getpass
userName = getpass.getuser()
# filepaths
n=1
imgs=[]
fp_in = r"C:\Users\\"+userName+"\Documents\Completed\\*.png"
fp_out = r"C:\Users\\"+userName+"\Documents\image.gif"

# https://pillow.readthedocs.io/en/stable/handbook/image-file-formats.html#gif

while n != 0:
	try:
		print("Added " + str(n)+".png")
		imgs +=[Image.open(r"C:\Users\\"+userName+"\Documents\Completed\\"+str(n)+".png")]
		n+=1
	except:
		print("End, Image wll not load properly for some compilers, mostly online ones (sorry there is no fix for this(that I found atleast))")
		img = Image.open(r"C:\Users\\"+userName+"\Documents\Completed\\"+str(n-1)+".png")
		break

img.save(fp_out, save_all=True, append_images=imgs)


'''
img, *imgs = [Image.open(f) for f in sorted(glob.glob(fp_in))]
'''
#img.save(fp=fp_out, format='GIF', append_images=imgs,save_all=True, duration=200, loop=0)