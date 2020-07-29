package Messaging;

public interface IMessage {
    Object unPackage(IMessage iMessage);
    void packContent();
}
