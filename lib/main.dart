import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
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
    List<String> responseList = List(4);

    MethodChannel _methodChannel = MethodChannel('flutter/MethodChannelDemo');

    try {
//      response = await _methodChannel.invokeMethod("Documents", "Flutter");
      List<dynamic> listResult = await _methodChannel.invokeMethod("Documents");
      print("Result: " + listResult.cast<String>().toString());
//***************************************************
//   viendo la manera de pasar mas de un dato de ida y vuetal

//      responseList = (await _methodChannel.invokeListMethod<String>(
//          'Documents', responseList));

//      'Documents', ['yom', 'jodesh', 'shana', 'yomView']));

//****************************************************
    } on Exception catch (e) {
      response = 'No answer';
      print("exception " + e.toString());
    }

    setState(() {
      _message = responseList[3];
    });
  }
}
