package c2

import groovy.util.GroovyTestCase;
import org.jcsp.lang.*
import org.jcsp.groovy.*


class testThreeToEight extends GroovyTestCase {

	void testMessage()
	{
		One2OneChannel channel0 = Channel.createOne2One()
		One2OneChannel channel1 = Channel.createOne2One()
	    CreateSetsOfEight test = new CreateSetsOfEight( inChannel: channel1.in() )
		
		def processList = [ new GenerateSetsOfThree ( outChannel: channel0.out() ),
		new ListToStream ( inChannel: channel0.in(),
							   outChannel: channel1.out() ),test
			
		  ]
		new PAR (processList).run()
		assertTrue(test.outList == [17,18,19,20,21,22,23,24] )
		
	}
}
