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

	@Test public void testNewMethod() throws Exception{
		Set<Method> expected = new HashSet<Method>();
		expected.add(new Method("extra", "()V"));

		ByteArrayInputStream a = new ByteArrayInputStream(Base64.decodeBase64(methodClass));
		ByteArrayInputStream b = new ByteArrayInputStream(Base64.decodeBase64(methodClassPlusExtra));
		Set<Method> m = App.findNewMethods(a, b);
		assertEquals(m, expected);
	}

	@Test public void testLostNewMethod() throws Exception{
		Set<Method> expected = new HashSet<Method>();

		ByteArrayInputStream a = new ByteArrayInputStream(Base64.decodeBase64(methodClassPlusExtra));
		ByteArrayInputStream b = new ByteArrayInputStream(Base64.decodeBase64(methodClass));
		Set<Method> m = App.findNewMethods(a, b);
		assertEquals(m, expected);

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

	final String methodClassPlusExtra =
"yv66vgAAADMAPQoADwAsBwAtCAAQCgACAC4IABIJAAgALwkACAAwBwAxCgAyADMKADIANAcANQoA" +
"CwAsCgALADYKAAsANwcAOAEABG5hbWUBABJMamF2YS9sYW5nL1N0cmluZzsBAARkZXNjAQAGPGlu" +
"aXQ+AQAnKExqYXZhL2xhbmcvU3RyaW5nO0xqYXZhL2xhbmcvU3RyaW5nOylWAQAEQ29kZQEAD0xp" +
"bmVOdW1iZXJUYWJsZQEAEkxvY2FsVmFyaWFibGVUYWJsZQEABHRoaXMBABBMbWNjb3lzdC9NZXRo" +
"b2Q7AQANU3RhY2tNYXBUYWJsZQcAMQcAOQEABmVxdWFscwEAFShMamF2YS9sYW5nL09iamVjdDsp" +
"WgEAAW8BABJMamF2YS9sYW5nL09iamVjdDsBAAR0aGF0AQAIaGFzaENvZGUBAAMoKUkBAAFoAQAB" +
"SQEACHRvU3RyaW5nAQAUKClMamF2YS9sYW5nL1N0cmluZzsBAAVleHRyYQEAAygpVgEAClNvdXJj" +
"ZUZpbGUBAAtNZXRob2QuamF2YQwAEwApAQAiamF2YS9sYW5nL0lsbGVnYWxBcmd1bWVudEV4Y2Vw" +
"dGlvbgwAEwA6DAAQABEMABIAEQEADm1jY295c3QvTWV0aG9kBwA5DAAdAB4MACIAIwEAF2phdmEv" +
"bGFuZy9TdHJpbmdCdWlsZGVyDAA7ADwMACYAJwEAEGphdmEvbGFuZy9PYmplY3QBABBqYXZhL2xh" +
"bmcvU3RyaW5nAQAVKExqYXZhL2xhbmcvU3RyaW5nOylWAQAGYXBwZW5kAQAtKExqYXZhL2xhbmcv" +
"U3RyaW5nOylMamF2YS9sYW5nL1N0cmluZ0J1aWxkZXI7ACEACAAPAAAAAgARABAAEQAAABEAEgAR" +
"AAAABQABABMAFAABABUAAACeAAMAAwAAACsqtwABK8cADbsAAlkSA7cABL8sxwANuwACWRIFtwAE" +
"vyortQAGKiy1AAexAAAAAwAWAAAAIgAIAAAABwAEAAgACAAJABIACwAWAAwAIAAOACUADwAqABAA" +
"FwAAACAAAwAAACsAGAAZAAAAAAArABAAEQABAAAAKwASABEAAgAaAAAAEwAC/wASAAMHABsHABwH" +
"ABwAAA0AAQAdAB4AAQAVAAAAmwACAAMAAAA3KyqmAAUErCvBAAiaAAUDrCvAAAhNLLQABiq0AAa2" +
"AAmZABUstAAHKrQAB7YACZkABwSnAAQDrAAAAAMAFgAAABoABgAAABQABQAVAAcAGAAOABkAEAAc" +
"ABUAHQAXAAAAIAADAAAANwAYABkAAAAAADcAHwAgAAEAFQAiACEAGQACABoAAAAMAAQHCPwAJAcA" +
"G0ABAAEAIgAjAAEAFQAAAF4AAgACAAAAHgQ8GxAfaCq0AAa2AApgPBsQH2gqtAAHtgAKYDwbrAAA" +
"AAIAFgAAABIABAAAACIAAgAjAA8AJAAcACUAFwAAABYAAgAAAB4AGAAZAAAAAgAcACQAJQABAAEA" +
"JgAnAAEAFQAAAEMAAgABAAAAGbsAC1m3AAwqtAAGtgANKrQAB7YADbYADrAAAAACABYAAAAGAAEA" +
"AAAqABcAAAAMAAEAAAAZABgAGQAAAAEAKAApAAEAFQAAACsAAAABAAAAAbEAAAACABYAAAAGAAEA" +
"AAAuABcAAAAMAAEAAAABABgAGQAAAAEAKgAAAAIAKw==";
}
