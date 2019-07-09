// Adding a clone method to PhoneNumber - page 55
package org.effectivejava.examples.chapter03.item11;

import java.util.HashMap;
import java.util.Map;

public final class PhoneNumber {

	// hashCode method with lazily initialized cached hash code
	private int hashCode;

	private final short areaCode;
	private final short prefix;
	private final short lineNumber;

	public PhoneNumber(int areaCode, int prefix, int lineNumber) {
		this.areaCode = (short) areaCode;
		this.prefix = (short) prefix;
		this.lineNumber = (short) lineNumber;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof PhoneNumber))
			return false;
		PhoneNumber pn = (PhoneNumber) o;
		return pn.lineNumber == lineNumber && pn.prefix == prefix
				&& pn.areaCode == areaCode;
	}

	@Override
	public int hashCode() {
		int result = 17;
		result = 31 * result + areaCode;
		result = 31 * result + prefix;
		result = 31 * result + lineNumber;
		return result;
	}


	// If a class is immutable and the cost of computing the hash code is significant
	public int cached_hashCode() {
		int result = hashCode;
		if (result == 0) {
			result = Short.hashCode(areaCode);
			result = 31 * result + Short.hashCode(prefix);
			result = 31 * result + Short.hashCode(lineNumber);
			hashCode = result;
		}
		return result;
	}

	public static void main(String[] args) {
		PhoneNumber pn = new PhoneNumber(707, 867, 5309);
		Map<PhoneNumber, String> m = new HashMap<PhoneNumber, String>();
		m.put(pn, "Jenny");
		System.out.println(m.containsKey(new PhoneNumber(707, 867, 5309)));
	}
}
