import 'package:flutter/material.dart';
import 'calculadora.dart';

void main() {
  runApp(const Principal2());
}

class Principal2 extends StatelessWidget {
  const Principal2({super.key});
  @override
  Widget build(BuildContextcontext) {
    return MaterialApp(
      home: Operaciones(),
    );
  }
}

class Operaciones extends StatefulWidget {
  const Operaciones({super.key});
  @override
  _OperacionesState createState() => _OperacionesState();
}

class _OperacionesState extends State<Operaciones> {
  final TextEditingController _caja1 = TextEditingController();
  final TextEditingController _caja2 = TextEditingController();
  int _resultado = 0;
  void _sumar() {
    final int numero1 = int.tryParse(_caja1.text) ?? 0;
    final int numero2 = int.tryParse(_caja2.text) ?? 0;

    final calculadora = Calculadora();
    setState(() {
      _resultado = calculadora.sumar(numero1, numero2);
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Suma de Numeros'),
      ),
      body: Padding(
        padding: EdgeInsets.all(16.0),
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            TextField(
              controller: _caja1,
              keyboardType: TextInputType.number,
              decoration: const InputDecoration(labelText: 'Numero1'),
            ),
            TextField(
              controller: _caja2,
              keyboardType: TextInputType.number,
              decoration: const InputDecoration(labelText: 'Numero2'),
            ),
            ElevatedButton(onPressed: _sumar, child: const Text('Sumar')),
            Text('Resultado: $_resultado')
          ],
        ),
      ),
    );
  }
}
