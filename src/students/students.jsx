/* Arquivo principal de Students */
import React, { Component } from 'react';
import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';
import { getAllStudents } from './studentsActions';

import ContentHeader from '../common/template/contentHeader';
import Content from '../common/template/content';
import Grid from '../common/layout/grid';
import Row from '../common/layout/row';

class Students extends Component {

  componentWillMount() {
    this.props.getAllStudents();
  }

  render() {
    // Renderiza as linhas
    const renderRows = () => {

      // fake students
      const students = [
        {
          "id": 1,
          "name": "Leanne Graham",
          "email": "Sincere@april.biz"
        },
        {
          "id": 2,
          "name": "Ervin Howell",
          "email": "Shanna@melissa.tv"
        },
        {
          "id": 3,
          "name": "Clementine Bauch",
          "email": "Nathan@yesenia.net"
        },
        {
          "id": 4,
          "name": "Patricia Lebsack",
          "email": "Julianne.OConner@kory.org"
        },
        {
          "id": 5,
          "name": "Chelsey Dietrich",
          "email": "Lucio_Hettinger@annie.ca"
        },
        {
          "id": 6,
          "name": "Mrs. Dennis Schulist",
          "email": "Karley_Dach@jasper.info"
        },
        {
          "id": 7,
          "name": "Kurtis Weissnat",
          "email": "Telly.Hoeger@billy.biz"
        },
        {
          "id": 8,
          "name": "Nicholas Runolfsdottir V",
          "email": "Sherwood@rosamond.me"
        },
        {
          "id": 9,
          "name": "Glenna Reichert",
          "email": "Chaim_McDermott@dana.io"
        },
        {
          "id": 10,
          "name": "Clementina DuBuque",
          "email": "Rey.Padberg@karina.biz"
        }
      ];

      /*
      *
      * A chamada abaixo pega os dados via ajax (axios) a partir de um endpoint (checar o arquivo studentsActions.js)
      * const students = this.props.students;
      *
      */

      return students.map(student => (
        <tr key={student.id}>
          <td>#{student.id}</td>
          <td>{student.name}</td>
          <td>{student.email}</td>
        </tr>
      ))
    }

    return (
      <div>
        <ContentHeader title='Alunos' />
        <Content>
          <Row>
            <Grid cols='12'>
              <div className="box">
                <div className="box-header">
                  <h3 className="box-title">Todos os Alunos</h3>
                </div>
                <div className="box-body">
                  <div className="dataTables_wrapper form-inline dt-bootstrap">
                    <Row>
                      <Grid cols='12'>
                        <table className='table table-bordered table-hover'>
                          <thead>
                            <tr>
                              <th>ID</th>
                              <th>Nome</th>
                              <th>Email</th>
                            </tr>
                          </thead>
                          <tbody>
                            {renderRows()}
                          </tbody>
                        </table>
                      </Grid>
                    </Row>
                  </div>
                </div>
              </div>
            </Grid>
          </Row>
        </Content>
      </div>
    )
  }
}

// mapeia o estados para propriedades e adiciona na store
const mapStateToProps = state => ({
  students: state.students.students
})

// Faz a ligacao entre as actionCreators criados
const mapDispatchToProps = dispatch => bindActionCreators({getAllStudents}, dispatch)

export default connect(mapStateToProps, mapDispatchToProps)(Students) // Retorna students integrado com o state
