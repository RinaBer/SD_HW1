package cs.technion.ac.il.sd.app;

import com.google.inject.AbstractModule;
import toposortImpl.ToposortImpl;

public class ToposortModule extends AbstractModule {
  @Override
  protected void configure() {
    bind(Toposort.class).to(ToposortImpl.class);
  }
}
