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

import javax.swing.JComboBox;
import javax.swing.JLabel;

/**
 * @since 1.0.0
 * @version 1.0.0 2015/03/03
 * @author kawakicchi
 */
public class DatabaseDefinitionExportDialog extends NavigationDialog {

	/** serialVersionUID */
	private static final long serialVersionUID = 7262283899094386816L;

	private ConnectionSettingPanel pnlConnectionSetting;

	public DatabaseDefinitionExportDialog() {
		pnlConnectionSetting = new ConnectionSettingPanel();

		add(pnlConnectionSetting);
	}

	private class ConnectionSettingPanel extends NavigationPanel {

		/** serialVersionUID */
		private static final long serialVersionUID = 493375226770177513L;

		private JLabel lblType;
		private JComboBox<String> cmbType;

		public ConnectionSettingPanel() {
			lblType = new JLabel("Type");
			cmbType = new JComboBox<String>(new String[] { "MySQL", "PostgreSQL" });

			setLayout(null);
			add(lblType);
			add(cmbType);

			addComponentListener(new ComponentAdapter() {
				@Override
				public void componentResized(final ComponentEvent e) {
					lblType.setBounds(10, 10, 120, 32);
					cmbType.setBounds(120, 10, 100, 32);
				}
			});
		}
	}
}
