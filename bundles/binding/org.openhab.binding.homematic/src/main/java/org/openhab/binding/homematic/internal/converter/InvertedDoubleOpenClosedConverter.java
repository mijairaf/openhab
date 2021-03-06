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
package org.openhab.binding.homematic.internal.converter;

import org.openhab.core.library.types.OpenClosedType;

/**
 * Converts an Double to an OpenCloseType. The given Double is considered to be
 * in a range of 0..1 (like percent). Only a value of 1.0 is converted to OPEN.
 * 
 * @author Thomas Letsch (contact@thomas-letsch.de)
 * @since 1.3
 * 
 */
public class InvertedDoubleOpenClosedConverter extends StateConverter<Double, OpenClosedType> {

    private static final Double MAX_VALUE = 1d;
    private static final Double MIN_VALUE = 0d;

    @Override
    protected OpenClosedType convertToImpl(Double source) {
        return (source == MAX_VALUE) ? OpenClosedType.OPEN : OpenClosedType.CLOSED;
    }

    @Override
    protected Double convertFromImpl(OpenClosedType source) {
        return source.equals(OpenClosedType.OPEN) ? MAX_VALUE : MIN_VALUE;
    }

}
