package com.mycompany.salestax.util;

public class ExceptionsLauncher {
	
	public static RuntimeException launch(Exception ex) {
		ExceptionsLauncher.<RuntimeException> launchAsUnchecked(ex);
		
		throw new AssertionError("This line is never executed but java doesn't know");
	}
	
	@SuppressWarnings("unchecked")
	private static <T extends Exception> void launchAsUnchecked(Exception toThrow) throws T {
		throw (T) toThrow;
	}
}