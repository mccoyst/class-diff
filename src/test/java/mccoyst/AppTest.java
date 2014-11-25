package mccoyst;

import java.io.*;
import java.util.*;

import org.junit.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.apache.commons.codec.binary.Base64;

public class AppTest {
	@Test public void testReadMethod() throws Exception{
		Set<Method> expected = new HashSet<Method>();
		expected.add(new Method("equals", "(Ljava/lang/Object;)Z"));
		expected.add(new Method("toString", "()Ljava/lang/String;"));
		expected.add(new Method("hashCode", "()I"));
		expected.add(new Method("<init>", "(Ljava/lang/String;Ljava/lang/String;)V"));

		ByteArrayInputStream bs = new ByteArrayInputStream(Base64.decodeBase64(methodClass));
		Set<Method> m = App.readMethods(bs);
		assertEquals(m, expected);
	}

	@Test public void testIdentity() throws Exception{
		ByteArrayInputStream a = new ByteArrayInputStream(Base64.decodeBase64(methodClass));
		ByteArrayInputStream b = new ByteArrayInputStream(Base64.decodeBase64(methodClass));
		Set<Method> m = App.findNewMethods(a, b);
		assertTrue(m.isEmpty());
	}

	final String methodClass =
"yv66vgAAADMAPAoADwAqBwArCAAQCgACACwIABIJAAgALQkACAAuBwAvCgAwADEKADAAMgcAMwoA" +
"CwAqCgALADQKAAsANQcANgEABG5hbWUBABJMamF2YS9sYW5nL1N0cmluZzsBAARkZXNjAQAGPGlu" +
"aXQ+AQAnKExqYXZhL2xhbmcvU3RyaW5nO0xqYXZhL2xhbmcvU3RyaW5nOylWAQAEQ29kZQEAD0xp" +
"bmVOdW1iZXJUYWJsZQEAEkxvY2FsVmFyaWFibGVUYWJsZQEABHRoaXMBABBMbWNjb3lzdC9NZXRo" +
"b2Q7AQANU3RhY2tNYXBUYWJsZQcALwcANwEABmVxdWFscwEAFShMamF2YS9sYW5nL09iamVjdDsp" +
"WgEAAW8BABJMamF2YS9sYW5nL09iamVjdDsBAAR0aGF0AQAIaGFzaENvZGUBAAMoKUkBAAFoAQAB" +
"SQEACHRvU3RyaW5nAQAUKClMamF2YS9sYW5nL1N0cmluZzsBAApTb3VyY2VGaWxlAQALTWV0aG9k" +
"LmphdmEMABMAOAEAImphdmEvbGFuZy9JbGxlZ2FsQXJndW1lbnRFeGNlcHRpb24MABMAOQwAEAAR" +
"DAASABEBAA5tY2NveXN0L01ldGhvZAcANwwAHQAeDAAiACMBABdqYXZhL2xhbmcvU3RyaW5nQnVp" +
"bGRlcgwAOgA7DAAmACcBABBqYXZhL2xhbmcvT2JqZWN0AQAQamF2YS9sYW5nL1N0cmluZwEAAygp" +
"VgEAFShMamF2YS9sYW5nL1N0cmluZzspVgEABmFwcGVuZAEALShMamF2YS9sYW5nL1N0cmluZzsp" +
"TGphdmEvbGFuZy9TdHJpbmdCdWlsZGVyOwAhAAgADwAAAAIAEQAQABEAAAARABIAEQAAAAQAAQAT" +
"ABQAAQAVAAAAngADAAMAAAArKrcAASvHAA27AAJZEgO3AAS/LMcADbsAAlkSBbcABL8qK7UABios" +
"tQAHsQAAAAMAFgAAACIACAAAAAcABAAIAAgACQASAAsAFgAMACAADgAlAA8AKgAQABcAAAAgAAMA" +
"AAArABgAGQAAAAAAKwAQABEAAQAAACsAEgARAAIAGgAAABMAAv8AEgADBwAbBwAcBwAcAAANAAEA" +
"HQAeAAEAFQAAAJsAAgADAAAANysqpgAFBKwrwQAImgAFA6wrwAAITSy0AAYqtAAGtgAJmQAVLLQA" +
"Byq0AAe2AAmZAAcEpwAEA6wAAAADABYAAAAaAAYAAAAUAAUAFQAHABgADgAZABAAHAAVAB0AFwAA" +
"ACAAAwAAADcAGAAZAAAAAAA3AB8AIAABABUAIgAhABkAAgAaAAAADAAEBwj8ACQHABtAAQABACIA" +
"IwABABUAAABeAAIAAgAAAB4EPBsQH2gqtAAGtgAKYDwbEB9oKrQAB7YACmA8G6wAAAACABYAAAAS" +
"AAQAAAAiAAIAIwAPACQAHAAlABcAAAAWAAIAAAAeABgAGQAAAAIAHAAkACUAAQABACYAJwABABUA" +
"AABDAAIAAQAAABm7AAtZtwAMKrQABrYADSq0AAe2AA22AA6wAAAAAgAWAAAABgABAAAAKgAXAAAA" +
"DAABAAAAGQAYABkAAAABACgAAAACACk=";
}
