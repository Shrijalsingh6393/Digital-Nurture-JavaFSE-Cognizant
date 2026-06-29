package com.pattern.decorator;

/**
 * Abstract decorator class implementing Notifier and wrapping another Notifier instance.
 */
public abstract class NotifierDecorator implements Notifier {
    protected final Notifier wrappedNotifier;

    /**
     * Constructs the decorator with the Notifier object to wrap.
     * 
     * @param notifier the Notifier being decorated
     */
    public NotifierDecorator(Notifier notifier) {
        this.wrappedNotifier = notifier;
    }

    /**
     * Delegating the send action to the wrapped notifier.
     * Concrete decorators will override/augment this method.
     */
    @Override
    public void send(String message) {
        wrappedNotifier.send(message);
    }
}
