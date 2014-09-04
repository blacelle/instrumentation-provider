InstrumentationProvider
=======================

This projects enables the injection of an Instrument without requiring to start with the -javaagent option

Install
======================
mvn install

Usage
==============
With jamm (https://github.com/jbellis/jamm), it can be used the following way:

	@Test
	public void testArrayListSize() {
		MemoryMeter mm = new MemoryMeter();
		MemoryMeter.premain(null, InstrumentationAgent.getInstrumentation());

		List<String> someList = new ArrayList<String>();

		{
			someList.add("firstString");

			long arrayListSize = mm.measureDeep(someList);
			Assert.assertEquals(144, arrayListSize);
		}

		{
			someList.add("secondString");

			long arrayListSize = mm.measureDeep(someList);
			Assert.assertEquals(208, arrayListSize);
		}
	}
