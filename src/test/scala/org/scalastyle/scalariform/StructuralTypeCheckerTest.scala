// Copyright (C) 2011-2012 the original author or authors.
// See the LICENCE.txt file distributed with this work for additional
// information regarding copyright ownership.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package org.scalastyle.scalariform

import org.junit.Test
import org.scalastyle.file.CheckerTest
import org.scalatest.junit.AssertionsForJUnit

// scalastyle:off magic.number

class StructuralTypeCheckerTest extends AssertionsForJUnit with CheckerTest {
  val key = "structural.type"
  val classUnderTest = classOf[StructuralTypeChecker]

  @Test def testKO(): Unit = {
    val source = """
package foobar

class Foobar {
  def string[T <: String](t: T) = {}
  def structuralType[T <: {def close(): Unit }](t: T) = {}
}
"""

    assertErrors(List(columnError(6, 26)), source)
  }
}
