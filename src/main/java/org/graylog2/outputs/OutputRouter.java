/**
 * Copyright 2012 Lennart Koopmann <lennart@socketfeed.com>
 *
 * This file is part of Graylog2.
 *
 * Graylog2 is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Graylog2 is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Graylog2.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package org.graylog2.outputs;

import org.graylog2.plugin.logmessage.LogMessage;
import org.graylog2.plugin.streams.Stream;
import org.graylog2.streams.StreamImpl;

/**
 * @author Lennart Koopmann <lennart@socketfeed.com>
 */
public class OutputRouter {
    
    public static boolean checkRouting(String outputTypeClass, LogMessage msg) {
        for (Stream stream : msg.getStreams()) {
            if (((StreamImpl) stream).hasConfiguredOutputs(outputTypeClass)) {
                return true;
            }
        }
        
        // No stream had that output configured.
        return false;
    }
    
}
