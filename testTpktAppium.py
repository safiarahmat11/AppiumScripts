import os
import unittest
from appium import webdriver
from time import sleep
import os, subprocess

# Returns abs path relative to this file and not cwd
PATH = lambda p: os.path.abspath(
    os.path.join(os.path.dirname(__file__), p)
)

class ContactsAndroidTests(unittest.TestCase):
    def setUp(self):
        subprocess.Popen('appium', shell=False)
        #os.system('appium &')
        desired_caps = {}
        desired_caps['platformName'] = 'Android'
        desired_caps['platformVersion'] = '5.0'
        desired_caps['deviceName'] = 'Nexus'
        #desired_caps['app'] = PATH(
         #   '/home/safia/eclipse-workspace/Appium/tPacketCapture_jp.co.taosoftware.android.packetcapture.apk'
        #)
        desired_caps['appPackage'] = 'jp.co.taosoftware.android.packetcapture'
        desired_caps['appActivity'] = 'jp.co.taosoftware.android.packetcapture.PacketCaptureActivity'

        self.driver = webdriver.Remote('http://0.0.0.0:4723/wd/hub', desired_caps)
        return self.driver

    def tearDown(self):
        self.driver.quit()
        self.appium.terminate()

    def test_add_contacts(self):
        el = self.driver.find_element_by_id("jp.co.taosoftware.android.packetcapture:id/captureToggleButton")
        el.click()

        #textfields = self.driver.find_element_by_id("android:id/button1")
        #textfields.click()
        


if __name__ == '__main__':
    #os.system('appium')
    #time.sleep(5)
    suite = unittest.TestLoader().loadTestsFromTestCase(ContactsAndroidTests)
    unittest.TextTestRunner(verbosity=2).run(suite)
