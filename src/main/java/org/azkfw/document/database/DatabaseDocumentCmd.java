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

import java.io.File;
import java.util.Date;

import org.azkfw.database.definition.model.DatabaseModel;
import org.azkfw.database.definition.parser.DatabaseDefinitionParser;
import org.azkfw.database.definition.parser.DatabaseDefinitionParserOption;
import org.azkfw.database.definition.parser.MySQLDefinitionParser;
import org.azkfw.database.definition.parser.PostgreSQLDefinitionParser;
import org.azkfw.document.database.xlsx.WriterOption;
import org.azkfw.document.database.xlsx.XLSXWriter;

/**
 * このクラスは、ドキュメントツールです。
 * 
 * @since 1.0.0
 * @version 1.0.0 2015/01/28
 * @author kawakicchi
 */
public final class DatabaseDocumentCmd {

	public static void main(final String[] args) {
		Strings.getInstance().load("org.azkfw.document.database.resource");
		
		execute(args);
	}

	private static void execute(final String[] args) {
		if (1 <= args.length) {
			String type = args[0];
			if ("export".equals(type)) {
				executeExport(subarray(args, 1));
			} else if ("help".equals(type)) {
				printHelp();
			} else {
				print("不明なタイプが指定されました。[%s]", type);
			}
		} else {
			printHelp();
		}
	}

	private static void executeExport(final String[] args) {
		if (6 <= args.length) {
			String driver = args[0];
			String url = args[1];
			String user = args[2];
			String pass = args[3];
			String schema = args[4];
			String dest = args[5];

			DatabaseDefinitionParserOption option = new DatabaseDefinitionParserOption();
			option.addIncludeSchema(schema);
			
			DatabaseDefinitionParser parser = null;
			if ("com.mysql.jdbc.Driver".equals(driver)) {
				parser = new MySQLDefinitionParser();
			} else if ("org.postgresql.Driver".equals(driver)) {
				parser = new PostgreSQLDefinitionParser();
			}
			parser.setOption(option);
			DatabaseModel database = parser.parse(driver, url, user, pass);
			if (null != database) {
				WriterOption opt = new WriterOption();
				opt.setCreateDate(new Date());

				XLSXWriter writer = new XLSXWriter();
				if (!writer.write(database, opt, new File(dest))) {
					print("データベース定義の書出しに失敗しました。");
				}
			} else {
				print("データベース定義の読込みに失敗しました。");
			}
		}
	}

	private static String[] subarray(final String[] strings, final int index) {
		String[] result = new String[strings.length - index];
		for (int i = index; i < strings.length; i++) {
			result[i - index] = strings[i];
		}
		return result;
	}

	private static void printHelp() {
		print("使用方法: AzukiDocumentTools TYPE OPTION...");
		print("TYPE で指定された処理を実行する。");
		print("TYPE の OPTION　詳細は、TYPE --help で表示する。");
		print("  TYPE");
		print("    export エクスポート処理");
		print("    help この使い方を表示して終了");
	}

	public static void print(final String message, final Object... values) {
		System.out.println(String.format(message, values));
	}
}
