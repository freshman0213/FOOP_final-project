import numpy as np
import cv2
import matplotlib.pyplot as plt


img = cv2.imread('ori.png')
print(img.shape)
for i in range(img.shape[0] - 100):
    cutImage = img[img.shape[0] - 100 - i : img.shape[0] - i]
    filename = str(i) + ".png"
    cv2.imwrite(filename, cutImage)