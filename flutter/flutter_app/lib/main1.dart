import 'package:flutter/material.dart';
import 'package:flutter/widgets.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Hola Mundo A',
      home: Scaffold(
        appBar: AppBar(
          title: const Text('Hola Mundo B'),
        ),
        body: const Center(
          child: Text('Hola Mundo C'),
        ),
      ),
    );
  }
}
