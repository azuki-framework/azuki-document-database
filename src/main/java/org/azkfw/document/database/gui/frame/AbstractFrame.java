/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.azkfw.document.database.gui.frame;

import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.util.Properties;

import javax.swing.JFrame;

/**
 * @since 1.0.0
 * @version 1.0.0 2015/03/03
 * @author kawakicchi
 */
public class AbstractFrame extends JFrame {

	/** serialVersionUID */
	private static final long serialVersionUID = -1109555108122577958L;

	protected final void setBounds() {
		setBounds((Properties) null);
	}

	protected final void setBounds(final Properties p) {
		GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
		Rectangle rt = env.getMaximumWindowBounds();
		if (null != p) {
			int x = toInt(p.getProperty(String.format("%s.x", this.getClass().getName())), -1);
			int y = toInt(p.getProperty(String.format("%s.y", this.getClass().getName())), -1);
			int width = toInt(p.getProperty(String.format("%s.width", this.getClass().getName())), -1);
			int height = toInt(p.getProperty(String.format("%s.height", this.getClass().getName())), -1);
			if (-1 != x && -1 != y && -1 != width && -1 != height) {
				rt = new Rectangle(x, y, width, height);
			}
		}
		setBounds(rt);
	}

	private int toInt(final String value, final int def) {
		int result = def;
		if (null != value && 1 < value.length()) {
			try {
				result = Integer.parseInt(value);
			} catch (NumberFormatException ex) {

			}
		}
		return result;
	}
}
