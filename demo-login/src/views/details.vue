<template>
  <div class="gym-club-list">
    <div v-for="gymClub in gymClubs" :key="gymClub.id" class="gym-club-card">
      <div class="gym-club-card-left">
        <img :src="gymClub.image" alt="Gym Image" class="gym-image" />
      </div>
      <div class="gym-club-card-right">
        <div class="gym-club-name">{{ gymClub.name }}</div>
        <el-form :model="gymClub" label-position="left" label-width="120px">
          <el-form-item label="Description">
            {{ gymClub.description }}
          </el-form-item>
          <el-form-item label="Country">
            {{ gymClub.country }}
          </el-form-item>
          <el-form-item label="City">
            {{ gymClub.city }}
          </el-form-item>
          <el-form-item label="Street Address">
            {{ gymClub.streetAddress }}
          </el-form-item>
          <el-form-item label="Phone">
            {{ gymClub.phone }}
          </el-form-item>
          <el-form-item label="Business Hours">
            {{ gymClub.businessHours }}
          </el-form-item>
          <el-form-item label="Average Rating">
            {{ gymClub.averageRating }}
          </el-form-item>
        </el-form>
      </div>
      <div class="gym-club-right">
        <div class="gym-club-equipment">
          <h3>Equipment</h3>
          <ul>
            <li v-for="equipment in gymClub.equipment" :key="equipment.id">
              <strong>{{ equipment.name }}:</strong> {{ equipment.description }} (Quantity: {{ equipment.quantity }})
            </li>
          </ul>
        </div>
        <div class="gym-club-coaches">
          <h3>Coaches</h3>
          <ul>
            <li v-for="coach in gymClub.coaches" :key="coach.id">
              <strong>{{ coach.name }}:</strong> {{ coach.contactInfo }} (Qualifications: {{ coach.qualifications }})
            </li>
          </ul>
        </div>
      </div>
    </div>
  </div>
</template>


<script>
export default {
  data() {
    return {
      gymClubs: [
        {
          id: 1,
          name: 'Gym Club 1',
          description: 'Description for Gym Club 1',
          country: 'Country 1',
          city: 'City 1',
          streetAddress: 'Address 1',
          phone: '123-456-7890',
          businessHours: '9:00 AM - 5:00 PM',
          averageRating: 4.5,
          image: '/path/to/your/image1.jpg',
          equipment: [
            {
              id: 1,
              name: 'Treadmill',
              description: 'Cardio machine',
              quantity: 10,
            },
            // Add more equipment as needed
          ],
          coaches: [
            {
              id: 1,
              name: 'John Doe',
              contactInfo: 'john@example.com',
              qualifications: 'Certified Personal Trainer',
            },
            // Add more coaches as needed
          ],
        },
        {
          id: 1,
          name: 'Gym Club 2',
          description: 'Description for Gym Club 1',
          country: 'Country 1',
          city: 'City 1',
          streetAddress: 'Address 1',
          phone: '123-456-7890',
          businessHours: '9:00 AM - 5:00 PM',
          averageRating: 4.5,
          image: '/path/to/your/image1.jpg',
          equipment: [
            {
              id: 1,
              name: 'Treadmill',
              description: 'Cardio machine',
              quantity: 10,
            },
            // Add more equipment as needed
          ],
          coaches: [
            {
              id: 1,
              name: 'John Doe',
              contactInfo: 'john@example.com',
              qualifications: 'Certified Personal Trainer',
            },
            // Add more coaches as needed
          ],
        },
        {
          id: 1,
          name: 'Gym Club 3',
          description: 'Description for Gym Club 1',
          country: 'Country 1',
          city: 'City 1',
          streetAddress: 'Address 1',
          phone: '123-456-7890',
          businessHours: '9:00 AM - 5:00 PM',
          averageRating: 4.5,
          image: '/path/to/your/image1.jpg',
          equipment: [
            {
              id: 1,
              name: 'Treadmill',
              description: 'Cardio machine',
              quantity: 10,
            },{
              id: 1,
              name: 'Treadmill',
              description: 'Cardio machine',
              quantity: 10,
            },
            // Add more equipment as needed
          ],
          coaches: [
            {
              id: 1,
              name: 'John Doe',
              contactInfo: 'john@example.com',
              qualifications: 'Certified Personal Trainer',
            },
            // Add more coaches as needed
          ],
        },
        // Repeat this structure for other gym clubs
      ],
    };
  },
};
</script>

<style>
.gym-club-list {
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
  margin: 10px;
}

.gym-club-card {
  width: 80%;
  background-color: #fff;
  margin: 10px;
  padding: 10px;
  border: 1px solid #ccc;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
  display: flex;
}

.gym-club-card-left {
  width: 30%;
  padding: 10px;
}

.gym-image {
  max-width: 100%;
}

.gym-club-card-right {
  width: 70%;
}

.gym-club-name {
  font-size: 24px;
  color: #00bfff; /* Light Blue */
  margin-bottom: 10px;
}
.gym-club-right {
  width: 30%;
  padding: 10px;
  background-color: #fff;
  border: 1px solid #ccc;
}

.gym-club-equipment h3,
.gym-club-coaches h3 {
  color: #00bfff; /* Light Blue */
}

.gym-club-equipment ul,
.gym-club-coaches ul {
  list-style: none;
  padding: 0;
  margin: 0;
}

.gym-club-equipment li,
.gym-club-coaches li {
  margin: 5px 0;
  color: #00bfff; /* Light Blue */
}
.gym-club-equipment ul,
.gym-club-coaches ul {
  list-style: none;
  padding: 0;
  margin: 20px 0; /* 增加上下间距为 20px */
}

.gym-club-equipment li,
.gym-club-coaches li {
  margin: 5px 0;
  color: #00bfff; /* Light Blue */
}
</style>
