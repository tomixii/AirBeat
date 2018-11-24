import math
import os
import sys
"""
x, y, z = float(sys.argv[1]), float(sys.argv[2]), float(sys.argv[3])
i = 0
#while (i < len(timestp)):
if (abs(x) > 0 + 5):
	os.system("start music/Basic_Rock_135.mp3")
elif (abs(y) > 2.3 + 5):
	os.system("start music/electricguitar.mp3")
elif (abs(z) > 9.5 + 5):
	os.system("start music/RatAtat_155.mp3")
else:
	os.system("start music/Cymbal_Groove.mp3")
#time.sleep(2)
i += 1
"""
with open("2018_11_24T18_48_14Z_589_1750300.csv") as file:
	timestp, x, y, z = [],[],[],[]
	for line in file:
		parts = line.split(',')
		if len(parts) > 6:
			timestp.append(float(parts[0]))
			x.append(float(parts[1] + '.' + parts[2]))
			y.append(float(parts[3] + '.' + parts[4]))
			z.append(float(parts[5] + '.' + parts[6]))
return timestp, x, y, z
'''
	i = 0
	while (i < len(timestp)):
		print(timestp[i])
		if (abs(x[i]) > average(x) + 5):
			os.system("start music/Basic_Rock_135.mp3")
		elif (abs(y[i]) > average(y) + 5):
			os.system("start music/electricguitar.mp3")
		elif (abs(z[i]) > average(z) + 5):
			os.system("start music/RatAtat_155.mp3")
		else:
			os.system("start music/Cymbal_Groove.mp3")
		time.sleep(2)
		i += 1
'''