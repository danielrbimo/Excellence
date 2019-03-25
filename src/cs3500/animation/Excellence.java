package cs3500.animation;

import java.io.FileNotFoundException;
import java.io.FileReader;

import cs3500.animation.controller.Controller;
import cs3500.animation.model.AnimationModel;
import cs3500.animation.model.animator.util.AnimationReader;
import cs3500.animation.model.AnimationModelImpl.Builder;
import cs3500.animation.view.EnhancedVisualView;
import cs3500.animation.view.IView;
import cs3500.animation.view.SVGView;
import cs3500.animation.view.TextualView;
import cs3500.animation.view.VisualView;

/**
 * Main method class.
 */
public final class Excellence {
  /**
   * Main method to run the program.
   *
   * @param args the arguments.
   */
  public static void main(String[] args) {
    AnimationModel model;
    IView view;
    Controller controller = null;
    Readable file = null;
    String outFile = "System.out";
    String viewType = "";
    int speed = 1;

    for (int i = 0; i < args.length; i++) {
      switch (args[i]) {
        case "-in":
          try {
            file = new FileReader(args[i + 1]);
          } catch (FileNotFoundException f) {
            f.printStackTrace();
          }
          break;
        case "-view":
          viewType = args[i + 1];
          break;
        case "-out":
          outFile = args[i + 1];
          break;
        case "-speed":
          speed = Integer.parseInt(args[i + 1]);
          break;
        default:
          break;
      }
    }
    try {
      model = AnimationReader.parseFile(file, new Builder());
    } catch (NullPointerException n) {
      throw new IllegalArgumentException("Cannot be null");
    }

    switch (viewType) {
      case "text":
        view = new TextualView(model, outFile, speed);
        controller = new Controller(view);
        break;
      case "svg":
        view = new SVGView(model, outFile, speed);
        controller = new Controller(view);
        break;
      case "visual":
        view = new VisualView(model,speed);
        controller = new Controller(view);
        break;
      case "edit":
        view = new EnhancedVisualView(model,speed);
        controller = new Controller(view);
        break;
      default:
        break;
    }
    controller.goAnimate();
  }
}
