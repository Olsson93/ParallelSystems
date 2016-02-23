package c17.test.net2
// copyright 2012-13 Jon Kerridge
// Let's Do It In Parallel
import org.jcsp.lang.*
import org.jcsp.groovy.*
import org.jcsp.net2.*
import org.jcsp.net2.tcpip.*
import org.jcsp.groovy.util.*

class RunTestPart extends GroovyTestCase {
	
	void testSomething() {	
	  def testPartIP = "127.0.0.1"  
	  def deviceIP = "127.0.0.2"
	  def testPartAddr = new TCPIPNodeAddress(testPartIP, 3000)
	  def deviceAddr = new TCPIPNodeAddress(deviceIP, 3000)
	  Node.getInstance().init(testPartAddr)	  
	  
	  def ordinaryOutput = NetChannel.one2net(deviceAddr, 50)
	  println "ordinaryOutput location = ${ordinaryOutput.getLocation()}"
	  def scaledInput = NetChannel.net2one()
	  println "scaledInput location = ${scaledInput.getLocation()}"
	  ordinaryOutput.write(1)
	  
      def collector = new CollectNumbers ( inChannel: scaledInput)
      def generator = new GenerateNumbers (outChannel: ordinaryOutput)
    
      def testList = [ collector, generator]
    
      new PAR(testList).run()
      
      def original = generator.generatedList
      def unscaled = collector.collectedList
      def scaled = collector.scaledList
      assertTrue (original == unscaled)
	  assertTrue (TestUtilities.list1GEList2(scaled, original))
	}
}
