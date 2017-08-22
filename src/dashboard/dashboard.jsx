/* Arquivo principal de Dashboard */
import React, { Component } from 'react';
import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';

import ContentHeader from '../common/template/contentHeader';
import Content from '../common/template/content';
import Grid from '../common/layout/grid';
import Row from '../common/layout/row';

// componente de classe
class Dashboard extends Component {

  componentWillMount() {

  }

  render() {

    return (
      <div>
        <ContentHeader title='Painel' subtitle='Versão 1.0' />
        <Content>
          <Row>
            <Grid cols='12 6'>(Conteúdo do painel)</Grid>
          </Row>
        </Content>
      </div>
    )
  }
}

// mapeia o estados para propriedades e adiciona na store
const mapStateToProps = state => ({

});

// Faz a ligacao entre as actionCreators criados
const mapDispatchToProps = dispatch => bindActionCreators({}, dispatch);

export default connect(mapStateToProps, mapDispatchToProps)(Dashboard); // Retorna o dashboard integrado com o state
