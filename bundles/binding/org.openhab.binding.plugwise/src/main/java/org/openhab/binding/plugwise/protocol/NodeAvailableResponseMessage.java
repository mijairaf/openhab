/**
 * openHAB, the open Home Automation Bus.
 * Copyright (C) 2010-2013, openHAB.org <admin@openhab.org>
 *
 * See the contributors.txt file in the distribution for a
 * full listing of individual contributors.
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation; either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, see <http://www.gnu.org/licenses>.
 *
 * Additional permission under GNU GPL version 3 section 7
 *
 * If you modify this Program, or any covered work, by linking or
 * combining it with Eclipse (or a modified version of that library),
 * containing parts covered by the terms of the Eclipse Public License
 * (EPL), the licensors of this Program grant you additional permission
 * to convey the resulting work.
 */
package org.openhab.binding.plugwise.protocol;

/**
 * Message to be sent to a Circle when its Node Available message is "accepted"
 *
 * @author Karel Goderis
 * @since 1.1.0
 */
public class NodeAvailableResponseMessage extends Message {

	boolean acceptanceCode;
	String destinationMAC;

	public NodeAvailableResponseMessage(boolean code, String destination) {
		super("", "");
		acceptanceCode = code;
		destinationMAC = destination;
		MAC="";
		type = MessageType.NODE_AVAILABLE_RESPONSE;

	}

	@Override
	protected String payLoadToHexString() {
		return String.format("%02X",acceptanceCode ? "01" : "00") + destinationMAC;
	}

	@Override
	protected void parsePayLoad() {
	}
	
	protected String sequenceNumberToHexString() {
		return "";
	}

}
