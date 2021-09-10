name := "generated"

Compile / sourceGenerators += Def.task {
  val targetDir = (Compile/sourceManaged).value / "test1"

  val javaFile = targetDir / "Test1.java"
  val scalaFile = targetDir / "_ONLY_FOR_INTELLIJ.scala"
  IO.write(javaFile,
    """package test1;
      |
      |public class Test1 {
      | public static final String VALUE1 = "VALUE1";
      |}
      |""".stripMargin)

  /** to fix the red squiggles in intellij bsp, uncomment the following lines,
    * then clean up (`rm -rf .bsp .idea && find . -type d -name target | xargs rm -rf`) 
    * and reimport into intellij */
  // IO.write(scalaFile,
  //   """package test1
  //     |
  //     |private class _ONLY_FOR_INTELLIJ
  //     |""".stripMargin)

  Seq(javaFile, scalaFile).filter(_.exists)
}.taskValue
