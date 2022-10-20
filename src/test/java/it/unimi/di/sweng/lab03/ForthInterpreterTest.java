package it.unimi.di.sweng.lab03;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;


@Timeout(2)
public class ForthInterpreterTest {


  private Interpreter interpreter;

  @BeforeEach
  public void setUp() throws Exception {
    interpreter = new ForthInterpreter();
  }

  @Test
  public void testStackEmpty() {
    interpreter.input("");
    assertThat(interpreter.toString()).isEqualTo("<- Top");
  }

  @Test
  public void testInput() {
    interpreter.input("1");
    assertThat(interpreter.toString()).isEqualTo("1 <- Top");
    interpreter.input("1 2");
    assertThat(interpreter.toString()).isEqualTo("1 2 <- Top");
  }

  @Test
  public void testInputSignum() {
    interpreter.input("1 -2 3");
    assertThat(interpreter.toString()).isEqualTo("1 -2 3 <- Top");
    interpreter.input("1 +2 3");
    assertThat(interpreter.toString()).isEqualTo("1 2 3 <- Top");
  }

}


