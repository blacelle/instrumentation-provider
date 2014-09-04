/**
 * Copyright (C) 2014 Benoit Lacelle (benoit.lacelle@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package blasd.instrumentation;

import org.junit.Assert;
import org.junit.Test;

public class TestInstrumentAgent {

	@Test
	public void testPID() {
		Assert.assertTrue(Integer.parseInt(InstrumentationAgent.discoverProcessIdForRunningVM()) > 0);
	}

	@Test
	public void testGetPathToJarFileContainingThisClass() {
		Assert.assertTrue(InstrumentationAgent.getPathToJarFileContainingThisClass(TestInstrumentAgent.class).endsWith("target/test-classes"));
	}

	@Test(expected = IllegalStateException.class)
	public void testinitializeIfNeeded() {
		// This test shall fail in Eclipse since we requires a .jar with a
		// manifest declaring the javaagent and the test can not be run in a
		// jar. We tried useManifestOnlyJar=true from
		// http://maven.apache.org/surefire/maven-surefire-plugin/examples/class-loading.html
		// but it fails since the manifest does not contains the javaagent
		// declaration
		InstrumentationAgent.initializeIfNeeded();
	}

}
