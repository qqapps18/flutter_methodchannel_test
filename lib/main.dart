import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        visualDensity: VisualDensity.adaptivePlatformDensity,
      ),
      home: MyHomePage(),
    );
  }
}

class MyHomePage extends StatefulWidget {
  @override
  _MyHomePageState createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  String _message = 'no message yet ... ';

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Home'),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            RaisedButton(
              child: Text('press the button'),
              onPressed: () {
                _getDocuments();
              },
            ),
            Text(_message),
          ],
        ),
      ),
    );
  }

  Future<void> _getDocuments() async {
    String response;
    MethodChannel _methodChannel = MethodChannel('flutter/MethodChannelDemo');
//    List<dynamic> documentList = [""];
    try {
      response = await _methodChannel.invokeMethod("Documents", "Flutter");
//      documentList = await _methodChannel.invokeMethod("Documents", "Flutter");
    } on Exception catch (e) {
      response = 'No answer';
      print("exception " + e.toString());
    }

    setState(() {
      _message = response;
    });
//    documentList.forEach((document) {
//      print("Document: $document"); // seach in Logcat "Document"
//    });
  }
}
