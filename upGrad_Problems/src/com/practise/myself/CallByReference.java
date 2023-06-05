package com.practise.myself;

public class CallByReference {
	int value;

	public static void main(String[] args) {
		CallByReference reference = new CallByReference();
		reference.value = 10;
		passByReference(reference);
		System.out.println(reference.value);
	}
	
	public static void passByReference(CallByReference referenceCopy) {
		referenceCopy.value = 15;
	}
}
