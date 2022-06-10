import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Dormitory {
}

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String filepath = "src/main/resources/dormitory.xml";
        ArrayList<Room> rooms = XmlReader.readUsersFromXml(filepath);
        menuProcessing(rooms);
        saveRoomsToXml(rooms, filepath);
    }

/*
    public static void saveUsersToXml(ArrayList<User> users, String filepath) {
        try {
            Document document = DocumentBuilderFactory.newInstance()
                    .newDocumentBuilder().newDocument();
            Element rootElement = document.createElement("users");
            document.appendChild(rootElement);

            for (User user : users) {
                Element userElement = document.createElement("user");
                rootElement.appendChild(userElement);
                createChildElement(document, userElement, "name", user.getName());
                createChildElement(document, userElement, "birthYear",
                        String.valueOf(user.getBirthYear()));
                createChildElement(document, userElement, "address", user.getAddress());
                createChildElement(document, userElement, "eyeColor",
                        user.getEyeColor().toString());
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new FileOutputStream(filepath));

            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            transformer.transform(source, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }