/* Arquivo principal de Students */
import React, { Component } from 'react';

import ContentHeader from '../common/template/contentHeader';
import Content from '../common/template/content';
import Grid from '../common/layout/grid';
import Row from '../common/layout/row';

class Calendar extends Component {
  render() {
    return (
      <div>
        <ContentHeader title='Calendário' />
        <Content>
          <Row>
            <Grid cols='12 6'>(Calendário integrado ao Google)</Grid>
          </Row>
        </Content>
      </div>
    )
  }
}

export default Calendar;
