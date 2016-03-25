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

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ca.uqac.lif.json.JsonParser.JsonParseException;

@SuppressWarnings("unused")
public class JsonTest
{
  JsonParser j_parser;
  
  @Before
  public void setUp() throws Exception
  {
    j_parser = new JsonParser();
  }
  
  @Test
  public void testParser1() throws IOException, JsonParseException
  {
    String json = PackageFileReader.readPackageFile(this.getClass(), "data/sample.json");
    JsonElement jse = j_parser.parse(json);
    assertNotNull(jse);
  }
  
  @Test
  public void testParser4() throws IOException, JsonParseException
  {
    String json = PackageFileReader.readPackageFile(this.getClass(), "data/sample-5.json");
    JsonElement jse = j_parser.parse(json);
    assertNotNull(jse);
  }
  
  @Test
  public void testParser2() throws IOException, JsonParseException
  {
    String json = PackageFileReader.readPackageFile(this.getClass(), "data/sample-2.json");
    JsonElement jse = j_parser.parse(json);
    assertNotNull(jse);
  }
  
  @Test
  public void testParser3() throws IOException, JsonParseException
  {
    JsonElement jse = j_parser.parse("[ ]");
    assertNotNull(jse);
  }
  
  @Test
  public void testParserLarge1() throws IOException, JsonParseException
  {
    int threshold_time_ms = 500;
    String json = PackageFileReader.readPackageFile(this.getClass(), "data/sample-7.json");
    long mil_start = System.currentTimeMillis();
    JsonElement jse = j_parser.parse(json);
    long mil_end = System.currentTimeMillis();
    long total_time_ms = mil_end - mil_start;
    assertNotNull(jse);
    if (total_time_ms > 500)
    {
      fail("Parsing took " + total_time_ms + " ms, expected less than " + threshold_time_ms + " ms");
    }
  }
  
  @Test
  public void testParserLarge2() throws IOException, JsonParseException
  {
    int threshold_time_ms = 500;
    String json = PackageFileReader.readPackageFile(this.getClass(), "data/sample-8.json");
    long mil_start = System.currentTimeMillis();
    JsonElement jse = j_parser.parse(json);
    long mil_end = System.currentTimeMillis();
    long total_time_ms = mil_end - mil_start;
    assertNotNull(jse);
    if (total_time_ms > 500)
    {
      fail("Parsing took " + total_time_ms + " ms, expected less than " + threshold_time_ms + " ms");
    }
  }
  
  @Test
  public void testGet1() throws IOException, JsonParseException
  {
    String json = PackageFileReader.readPackageFile(this.getClass(), "data/sample.json");
    JsonElement jse = j_parser.parse(json);
    JsonElement answer = JsonPath.get(jse, "children[0].tagname");
    if (!(answer instanceof JsonString))
    {
      fail("Expected string, got something else");
    }
    JsonString s_answer = (JsonString) answer;
    if (s_answer.stringValue().compareTo("h1") != 0)
    {
      fail("Expected h1, got " + s_answer.stringValue());
    }
  }
  
  @Test
  public void testGet2() throws IOException, JsonParseException
  {
    String json = PackageFileReader.readPackageFile(this.getClass(), "data/sample-4.json");
    JsonElement jse = j_parser.parse(json);
    JsonElement answer = JsonPath.get(jse, "children[0].children[1].children[0].children[0].tagname");
    if (!(answer instanceof JsonString))
    {
      fail("Expected string, got something else");
    }
    JsonString s_answer = (JsonString) answer;
    if (s_answer.stringValue().compareTo("#CDATA") != 0)
    {
      fail("Expected #CDATA, got " + s_answer.stringValue());
    }
  }

}
