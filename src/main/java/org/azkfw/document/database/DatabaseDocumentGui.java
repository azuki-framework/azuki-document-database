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
package org.azkfw.document.database;

import org.azkfw.document.database.gui.dialog.DatabaseDefinitionExportDialog;

/**
 * @since 1.0.0
 * @version 1.0.0 2015/03/03
 * @author kawakicchi
 */
public class DatabaseDocumentGui {

	/**
	 * 
	 * @param args
	 */
	public static void main(final String[] args) {
		Strings.getInstance().load("org.azkfw.document.database.resource");

		// uri
		//MainFrame frm = new MainFrame();
		//frm.setVisible(true);
		DatabaseDefinitionExportDialog dlg = new DatabaseDefinitionExportDialog();
		dlg.setVisible(true);
	}

}
