import os, subprocess
import csv
import time

def main():
	with open('<path to csv>.csv', mode='r') as infile:
		reader=csv.reader(infile)
		#with open('/home/safia/drebinDataset/apkWithInternet/withPkgName/drebin0_new.csv', mode='w') as outfile:
		#writer=csv.writer(outfile)
		mydict={rows[2]:rows[3] for rows in reader}
	print(mydict)
	apk=list(mydict.keys())
	pkg=list(mydict.values())
	print(apk)
	print(pkg[0])
	os.system("adb install sample117.apk")
	monkeycmd = "adb shell monkey -p " + pkg[0] + " -c android.intent.category.LAUNCHER 1"
	print(monkeycmd)
	monkeyprocess = os.system(monkeycmd)
	time.sleep(60)
	os.system("adb uninstall " + pkg[0])
	#os.system("adb shell monkey -p" + pkg[0] + "-c android.intent.category.LAUNCHER 1")


if __name__ == '__main__':
	main()
