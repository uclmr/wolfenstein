package controllers.doc

import controllers.{Result, Input}
import controllers.util.JacksonWrapper

/**
 * @author sameer
 */
case class Cell(id: Int, compiler: String, input: Input) {
  def escapedContent: String = input.code.replaceAll("\\\\", "\\\\\\\\").replaceAll("\n", "\\\\n").replaceAll("\t", "\\\\t").replaceAll("'", "\\\\'")
  def inputJson: String = JacksonWrapper.serialize(input)
}

/*
case class Scala(id: Int, code: String, output: String) extends Cell {
  def staticHTML =
    """
      | <div id="editor%d" class="cell light-border">%s</div>
      | <div id="renderDisplay%d">%s</div>
      | <script>
      |                var id = %d;
      |                var mode = "scala";
      |
      |                var editor = ace.edit("editor"+id);
      |                editor.setTheme("ace/theme/solarized_light");
      |                editor.getSession().setMode("ace/mode/scala");
      |                editor.focus();
      |                editor.navigateFileEnd();
      |
      |                heightUpdateFunction(editor, '#editor'+id);
      | </script>
    """.stripMargin format(id, code, id, output, id)
}*/
