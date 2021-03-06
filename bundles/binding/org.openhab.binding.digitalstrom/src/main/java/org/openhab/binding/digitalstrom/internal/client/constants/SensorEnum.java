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
package org.openhab.binding.digitalstrom.internal.client.constants;

import java.util.HashMap;

/**
 * @author 	Alexander Betker
 * @since 1.3.0
 * @version	digitalSTROM-API 1.14.5
 */
public enum SensorEnum {
	
	ACTIVE_POWER				(4, "Watts (W)",			0.0f,	4095.0f,	1.0f, 	12),
	OUTPUT_CURRENT				(5, "Ampere (mA)",			0.0f,	4095.0f,	1.0f, 	12),
	ELECTRIC_METER				(6, "Watthours (kWh)",		0.0f,	40.95f,		0.1f, 	12),
	TEMPERATURE_INDOORS			(9, "Kelvin (K)",			230.0f,	332.3f,		0.025f,	10),
	TEMPERATURE_OUTDOORS		(10, "Kelvin (K)",			230.0f,	332.3f,		0.025f,	10),
	RELATIVE_HUMIDITY_INDOORS	(13, "Percent (%)",			0.0f,	102.3f,		0.1f,	10),
	RELATIVE_HUMIDITY_OUTDOORS	(14, "Percent (%)",			0.0f,	102.3f,		0.1f,	10),
	AIR_PRESSURE				(15, "Pascal (hPa)",		0.0f,	102.3f,		0.1f,	10),
	WIND_SPEED					(18, "m/s",					0.0f,	102.3f,		0.1f,	10),
	PRECIPITATION				(20, "mm/m2",				0.0f,	102.3f,		0.1f,	10),
	OUTPUT_CURRENT_H			(64, "Ampere (mA)",			0.0f,	16380.0f,	4.0f,	12),
	POWER_CONSUMPTION			(65, "Volt-Ampere (VA)",	0.0f,	4095.0f,	1.0f,	12);
	
	private final int		sensorType;
	private final String	unit;
	private final float		minValue;
	private final float		maxvalue;
	private final float		resolution;
	private final int		valueRange;
	
	static final HashMap<Integer, SensorEnum> sensorEnums = new HashMap<Integer, SensorEnum>();
	
	static {
		for (SensorEnum sensor:SensorEnum.values()) {
			sensorEnums.put(sensor.getSensorType(), sensor);
		}
	}
	
	public static boolean containsSensor(Integer index) {
		return sensorEnums.keySet().contains(index);
	}
	
	public static SensorEnum getSensor(Integer index) {
		return sensorEnums.get(index);
	}
	
	SensorEnum(int sensorType, String description, float min, float max, float resolution, int valueRange) {
		this.sensorType = sensorType;
		this.unit	= description;
		this.minValue	= min;
		this.maxvalue	= max;
		this.resolution	= resolution;
		this.valueRange	= valueRange;
	}
	
	public int getSensorType() {
		return this.sensorType;
	}
	
	public String getUnit() {
		return this.unit;
	}
	
	public float getMinValue() {
		return this.minValue;
	}
	
	public float getMaxValue() {
		return this.maxvalue;
	}
	
	public float getResolution() {
		return this.resolution;
	}
	
	/**
	 * Get value range (in bits)
	 * @return	value range of bits
	 */
	public int getRange() {
		return this.valueRange;
	}

}
