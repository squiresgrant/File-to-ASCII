#convert gif to frames
from PIL import Image

from PIL import GifImagePlugin

import getpass
userName = getpass.getuser()

imageObject = Image.open(r"C:\Users\\"+userName+"\Documents\Input\\a.gif")

print(imageObject.is_animated)

print(imageObject.n_frames)

 

# Display individual frames from the loaded animated GIF file
n = 0
for frame in range(0,imageObject.n_frames):

    imageObject.seek(frame)
    imageObject.save(r"C:\Users\\"+userName+"\Documents\Input\\"+str(n)+".png")
    n+=1
    imageObject.show()