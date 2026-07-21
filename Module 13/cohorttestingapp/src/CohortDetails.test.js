import React from 'react';
import { shallow, mount } from 'enzyme';
import CohortDetails from './CohortDetails';
import { CohortData } from './Cohort';

describe('Cohort Details Component', () => {
  // Test - 1: should create the component
  test('should create the component', () => {
    const wrapper = shallow(<CohortDetails cohort={CohortData[0]} />);
    expect(wrapper.exists()).toBe(true);
  });

  // Test - 2: should initialize the props
  test('should initialize the props', () => {
    const wrapper = mount(<CohortDetails cohort={CohortData[0]} />);
    expect(wrapper.props().cohort).toEqual(CohortData[0]);
  });

  // Test - 3: should display cohort code in h3
  test('should display cohort code in h3', () => {
    const wrapper = mount(<CohortDetails cohort={CohortData[0]} />);
    const h3Element = wrapper.find('h3');
    expect(h3Element.text()).toContain(CohortData[0].code);
  });

  // Test - 4: should always render same html
  test('should always render same html', () => {
    const wrapper = shallow(<CohortDetails cohort={CohortData[0]} />);
    expect(wrapper).toMatchSnapshot();
  });
});
