import Trainer from './Trainer';

export const mockTrainers = [
  new Trainer(
    1,
    'John Doe',
    'john.doe@cognizant.com',
    '9876543210',
    'Java Full Stack',
    ['Java', 'Spring Boot', 'React', 'Microservices']
  ),
  new Trainer(
    2,
    'Jane Smith',
    'jane.smith@cognizant.com',
    '9876543211',
    'Python Data Science',
    ['Python', 'Pandas', 'FastAPI', 'Machine Learning']
  ),
  new Trainer(
    3,
    'Robert Johnson',
    'robert.j@cognizant.com',
    '9876543212',
    'Cloud Native',
    ['AWS', 'Docker', 'Kubernetes', 'Terraform']
  )
];

export default mockTrainers;
