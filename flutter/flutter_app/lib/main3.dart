import 'package:flutter/material.dart';

void main() {
  runApp(const Principal1());
}

class Principal1 extends StatelessWidget {
  const Principal1({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: const Text('Contador'),
        ),
        body: const Center(
          child: ContenidoDinamico(),
        ),
      ),
    );
  }
}

class ContenidoDinamico extends StatefulWidget {
  const ContenidoDinamico({super.key});

  @override
  _ContenidoDinamicoState createState() => _ContenidoDinamicoState();
}

class _ContenidoDinamicoState extends State<ContenidoDinamico> {
  int _cont = 0;

  void _incrementarCont() {
    setState(() {
      _cont++;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Column(
      mainAxisAlignment: MainAxisAlignment.center,
      children: <Widget>[
        const Text('Presione el botón'),
        Text('$_cont', style: const TextStyle(fontSize: 24)),
        ElevatedButton(
          onPressed: _incrementarCont,
          style: ElevatedButton.styleFrom(
            backgroundColor: Colors.blue,
          ),
          child: const Text('Presioname'),
        ),
      ],
    );
  }
}
