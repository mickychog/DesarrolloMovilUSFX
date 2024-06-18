import 'package:flutter/material.dart';
import 'package:flutter_application_1/custom_button.dart';
import 'package:flutter_application_1/detailscreen1.dart';
import 'package:flutter_application_1/detailscreen2.dart';
import 'package:flutter_application_1/complejos.dart';

void main() {
  runApp(const Principal());
}

class Principal extends StatelessWidget {
  const Principal({super.key});
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      home: MyHomePage(),
      routes: <String, WidgetBuilder>{
        '/details1': (BuildContext context) => new DetailScreen1(),
        '/details2': (BuildContext context) => new DetailScreen2(),
        '/complejos': (BuildContext context) => new Complejos(),
      },
    );
  }
}

class MyHomePage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return new Scaffold(
      appBar: AppBar(
        title: const Text('Desarrollo Movil'),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            // ElevatedButton(
            //   onPressed: () {
            //     Navigator.of(context).pushNamed('/details1');
            //   },
            //   child: const Text('Pantalla de detalles 1'),
            // ),
            const SizedBox(height: 20),
            CustomButton(
              text: 'Base Datos',
              color: Colors.blue,
              onPressed: () {
                Navigator.of(context).pushNamed('/details2');
              },
            ),
            const SizedBox(height: 10), // Espacio entre los botones
            CustomButton(
              text: 'Calculadora',
              color: Colors.yellow,
              onPressed: () {
                Navigator.of(context).pushNamed('/details2');
              },
            ),
            const SizedBox(height: 10), // Espacio entre los botones
            CustomButton(
              text: 'Complejos',
              color: const Color.fromARGB(255, 68, 33, 243),
              onPressed: () {
                Navigator.of(context).pushNamed('/complejos');
              },
            ),
            const SizedBox(height: 10), // Espacio entre los botones
            CustomButton(
              text: 'Web Service',
              color: const Color.fromARGB(255, 44, 243, 33),
              onPressed: () {
                Navigator.of(context).pushNamed('/details2');
              },
            ),
            const SizedBox(height: 10), // Espacio entre los botones
            CustomButton(
              text: 'Salir',
              color: Color.fromARGB(255, 244, 23, 23),
              onPressed: () {
                Navigator.of(context).pushNamed('/details2');
              },
            ),

            // ElevatedButton(
            //   onPressed: () {
            //     Navigator.of(context).pushNamed('/details2');
            //   },
            //   child: const Text('Pantalla de detalles 2'),
            // ),
          ],
        ),
      ),
    );
  }
}
