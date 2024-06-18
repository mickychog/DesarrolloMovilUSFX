import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Operaciones con Complejos',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: const Complejos(),
    );
  }
}

class Complejos extends StatefulWidget {
  const Complejos({super.key});

  @override
  _ComplejosState createState() => _ComplejosState();
}

class _ComplejosState extends State<Complejos> {
  final TextEditingController _real1Controller = TextEditingController();
  final TextEditingController _imag1Controller = TextEditingController();
  final TextEditingController _real2Controller = TextEditingController();
  final TextEditingController _imag2Controller = TextEditingController();

  double a = 0;
  double b = 0;
  double c = 0;
  double d = 0;

  String _result = '';

  void _updateValues() {
    a = double.tryParse(_real1Controller.text) ?? 0;
    b = double.tryParse(_imag1Controller.text) ?? 0;
    c = double.tryParse(_real2Controller.text) ?? 0;
    d = double.tryParse(_imag2Controller.text) ?? 0;
  }

  void _sumar() {
    _updateValues();
    final double real = a + c;
    final double imag = b + d;

    setState(() {
      _result = 'Resultado: $real + ${imag}i';
    });
  }

  void _restar() {
    _updateValues();
    final double real = a - c;
    final double imag = b - d;

    setState(() {
      _result = 'Resultado: $real + ${imag}i';
    });
  }

  void _multiplicar() {
    _updateValues();
    final double real = a * c - b * d;
    final double imag = a * d + b * c;

    setState(() {
      _result = 'Resultado: $real + ${imag}i';
    });
  }

  void _dividir() {
    _updateValues();
    final double divisor = c * c + d * d;
    final double real = (a * c + b * d) / divisor;
    final double imag = (b * c - a * d) / divisor;

    setState(() {
      _result = 'Resultado: $real + ${imag}i';
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Operaciones con Complejos'),
      ),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            TextField(
              controller: _real1Controller,
              keyboardType: TextInputType.number,
              decoration: const InputDecoration(
                labelText: 'a (Parte Real)',
              ),
            ),
            TextField(
              controller: _imag1Controller,
              keyboardType: TextInputType.number,
              decoration: const InputDecoration(
                labelText: 'b (Parte Imaginaria)',
              ),
            ),
            const SizedBox(height: 20),
            TextField(
              controller: _real2Controller,
              keyboardType: TextInputType.number,
              decoration: const InputDecoration(
                labelText: 'c (Parte Real)',
              ),
            ),
            TextField(
              controller: _imag2Controller,
              keyboardType: TextInputType.number,
              decoration: const InputDecoration(
                labelText: 'd (Parte Imaginaria)',
              ),
            ),
            const SizedBox(height: 20),
            Row(
              mainAxisAlignment: MainAxisAlignment.spaceAround,
              children: <Widget>[
                ElevatedButton(
                  onPressed: _sumar,
                  child: const Text('Sumar'),
                ),
                ElevatedButton(
                  onPressed: _restar,
                  child: const Text('Restar'),
                ),
              ],
            ),
            const SizedBox(height: 10),
            Row(
              mainAxisAlignment: MainAxisAlignment.spaceAround,
              children: <Widget>[
                ElevatedButton(
                  onPressed: _multiplicar,
                  child: const Text('Multiplicar'),
                ),
                ElevatedButton(
                  onPressed: _dividir,
                  child: const Text('Dividir'),
                ),
              ],
            ),
            const SizedBox(height: 20),
            Text(
              _result,
              style: const TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
            ),
          ],
        ),
      ),
    );
  }
}
