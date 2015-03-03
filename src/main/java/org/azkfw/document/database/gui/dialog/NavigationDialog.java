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
package org.azkfw.document.database.gui.dialog;

import java.awt.Component;
import java.awt.GraphicsEnvironment;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JDialog;
import javax.swing.JPanel;

/**
 * @since 1.0.0
 * @version 1.0.0 2015/03/03
 * @author kawakicchi
 */
public class NavigationDialog extends JDialog {

	/** serialVersionUID */
	private static final long serialVersionUID = 4682796406318059074L;

	private final int navigationWidth = 160;
	private final int controlHeight = 36;

	private JPanel pnlNavigation;
	private JPanel pnlClient;
	private NavigationControlPanel pnlControl;

	public NavigationDialog() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLayout(null);

		pnlNavigation = new JPanel();
		pnlClient = new JPanel();
		pnlControl = new NavigationControlPanel();

		add(pnlNavigation);
		add(pnlClient);
		add(pnlControl);

		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(final ComponentEvent e) {
				doResize();
			}
		});

		GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
		Rectangle rt = env.getMaximumWindowBounds();
		//setBounds(rt);
		// TODO: debug
		setBounds(100, 100, 800, 600);
	}

	public void add(final NavigationPanel panel) {
		pnlClient.add(panel);

		if (1 == pnlClient.getComponentCount()) {
			pnlClient.setVisible(true);
			pnlControl.refresh(panel);
		}

		panel.setBounds(0, 0, pnlClient.getWidth(), pnlClient.getHeight());
	}

	private void doResize() {
		Insets insets = getInsets();

		int width = getWidth() - (insets.left + insets.right);
		int height = getHeight() - (insets.top + insets.bottom);

		pnlNavigation.setBounds(0, 0, navigationWidth, height);
		pnlClient.setBounds(navigationWidth, 0, width - navigationWidth, height - controlHeight);
		pnlControl.setBounds(navigationWidth, height - controlHeight, width - navigationWidth, controlHeight);

		for (final Component c : pnlClient.getComponents()) {
			c.setBounds(0, 0, pnlClient.getWidth(), pnlClient.getHeight());
		}
	}
}
