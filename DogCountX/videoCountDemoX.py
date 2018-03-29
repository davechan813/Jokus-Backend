import cv2
import detector
from PIL import Image

vidcap = cv2.VideoCapture('video.mp4')
success,image = vidcap.read()
count = 0
people_cnt = 0
success = True

success2, image2 = vidcap.read()
cv2.imwrite("out.jpg", image2)
plt = detector.detector3("out.jpg")
plt.savefig("tmpframe.png")
frame = cv2.imread("tmpframe.png")
height, width, layers = frame.shape
video = cv2.VideoWriter("out.avi",cv2.VideoWriter_fourcc(*'XVID'), 25, (width, height), True)


# put text

font                   = cv2.FONT_HERSHEY_SIMPLEX
bottomLeftCornerOfText = (40,80)
fontScale              = 1
fontColor              = (0,0,0)
lineType               = 2




while success:
	success,image = vidcap.read()
	count += 1
	final = cv2.imread("tmpframe.png")
	if count % 10 == 0 :
		cv2.imwrite("out.jpg", image)
		people_cnt = detector.detector2("out.jpg")  # print
		plt = detector.detector3("out.jpg")
		plt.savefig("tmpframe.png")
		
	cv2.putText(final,str(people_cnt), bottomLeftCornerOfText, font, fontScale,fontColor,lineType)
	video.write(final)

cv2.destroyAllWindows()
print count
video.release()
print 'released'
