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

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * @since 1.0.0
 * @version 1.0.0 2015/03/03
 * @author kawakicchi
 */
public class NavigationControlPanel extends JPanel {

	/** serialVersionUID */
	private static final long serialVersionUID = 2218356870675457353L;

	private JButton btnBack;
	private JButton btnNext;
	private JButton btnCancel;

	private final int margin = 6;
	private final int buttonMargin = 20;
	private final int buttonWidth = 120;

	public NavigationControlPanel() {
		setLayout(null);

		btnBack = new JButton();
		btnNext = new JButton();
		btnCancel = new JButton();
		add(btnBack);
		add(btnNext);
		add(btnCancel);

		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(final ComponentEvent e) {
				doResize();
			}
		});
	}

	public void refresh(final NavigationPanel panel) {
		btnBack.setText(panel.getBackButtonLabel());
		btnNext.setText(panel.getNextButtonLabel());
		btnCancel.setText(panel.getCancelButtonLabel());
	}

	private void doResize() {
		int width = getWidth();
		int height = getHeight();

		btnCancel.setBounds(width - (margin + buttonWidth * 1), 4, buttonWidth, (height-8));
		btnNext.setBounds(width - (margin + buttonWidth * 2 + buttonMargin * 1), 4, buttonWidth, (height-8));
		btnBack.setBounds(width - (margin + buttonWidth * 3 + buttonMargin * 2), 4, buttonWidth, (height-8));
	}
}
