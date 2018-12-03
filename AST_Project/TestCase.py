import unittest
import Robot_recognizer
class KnownValues(unittest.TestCase):
    def test_confidence_level(self):
        result = Robot_recognizer.recognise(RGBD,RGB)
        expected = [array(['knife', '1', '0.99'], dtype='|S7'), array(['scissor', '2', '0.95'], dtype='|S7'), array(['fork', '3', '0.99'], dtype='|S7'), array(['spoon', '4', '0.99'], dtype='|S7'), array(['keys', '5', '0.95'], dtype='|S7')]
        self.assertEqual(expected,result)
if __name__=='__main__':
    unittest.main()