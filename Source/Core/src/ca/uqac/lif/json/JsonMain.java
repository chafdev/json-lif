/*
    json-lif, manipulate JSON elements in Java
    Copyright (C) 2015-2016 Sylvain Hallé

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU Lesser General Public License as published
    by the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package ca.uqac.lif.json;

/**
 * Main class that simply displays the version number and
 * license information.
 */
public class JsonMain
{
	/**
	 * Dummy main
	 * @param args The command-line arguments (ignored)
	 */
	public static void main(String[] args)
	{
		String version = "1.2";
		System.out.println("json-lif version " + version + ", manipulate JSON elements in Java");
		System.out.println("(C) 2015-2016 Sylvain Hallé, Université du Québec à Chicoutimi");
		System.out.println("This JAR is not meant to be executed as a stand-alone program.");
	}

}
